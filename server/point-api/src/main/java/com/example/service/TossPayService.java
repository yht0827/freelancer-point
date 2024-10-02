package com.example.service;

import static com.example.CodeEnum.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.CustomException;
import com.example.entity.freelancer.Freelancer;
import com.example.entity.point.Point;
import com.example.repository.point.PointRepository;
import com.example.repository.point.dto.TossPayRequest;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TossPayService implements PointService {

	@Value("${toss-payment.secret-key}")
	private String tossSecretKey;

	@Value("${toss-payment.base-url}")
	private String tossUrl;

	private final PointRepository pointRepository;

	@Transactional
	public void pay(Freelancer freelancer, final Point point) {
		pointRepository.save(point);

		freelancer.addPoint(point.getAmount());
	}

	public Point tossConfirm(final TossPayRequest tossPayRequest) {
		Map<String, String> map = new HashMap<>();
		map.put("orderId", tossPayRequest.orderId());
		map.put("amount", tossPayRequest.amount());
		map.put("paymentKey", tossPayRequest.paymentKey());

		JSONObject obj = new JSONObject(map);

		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode((tossSecretKey + ":").getBytes(StandardCharsets.UTF_8));
		String authorizations = "Basic " + new String(encodedBytes);

		try {
			URL url = URI.create(tossUrl).toURL();
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("Authorization", authorizations);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(obj.toString().getBytes(StandardCharsets.UTF_8));

			int code = connection.getResponseCode();
			boolean isSuccess = code == 200;

			InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();

			Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
			JSONParser parser = new JSONParser();

			JSONObject jsonObject = (JSONObject)parser.parse(reader);
			JSONObject easyPay = (JSONObject)jsonObject.get("easyPay");

			responseStream.close();

			return Point.builder()
				.payType("toss")
				.orderId(String.valueOf(jsonObject.get("orderId")))
				.amount((long)easyPay.get("amount"))
				.memberId(tossPayRequest.memberId())
				.build();

		} catch (Exception e) {
			throw new CustomException(TOSS_PAYMENT_ERROR);
		}
	}
}
