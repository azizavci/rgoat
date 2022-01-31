package com.rzk.RitzyGoat.api.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyzipay.Options;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.BasketItemType;
import com.iyzipay.model.Buyer;
import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Payment;
import com.iyzipay.model.PaymentCard;
import com.iyzipay.model.PaymentChannel;
import com.iyzipay.model.PaymentGroup;
import com.iyzipay.request.CreatePaymentRequest;
import com.rzk.RitzyGoat.business.abstracts.AddressService;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PaymentsController {

	private AddressService addressService;

	@Autowired
	public PaymentsController(AddressService addressService) {

		this.addressService = addressService;

	}

	@PostMapping("/payment")
	public ResponseEntity<?> payment(@Valid @RequestBody CreatePaymentRequest createPaymentRequest) {

		Options options = new Options();
		options.setApiKey("sandbox-cvFrl3qL0KWtBBOpXC417rqGuqYRn66I");
		options.setSecretKey("sandbox-CpQT5aLprYsaruwFa6SMIplRNmbhlNDM");
		options.setBaseUrl("https://sandbox-api.iyzipay.com");

		// CreatePaymentRequest request = new CreatePaymentRequest();
		createPaymentRequest.setLocale(Locale.TR.getValue());
		createPaymentRequest.setConversationId("123456789");
		createPaymentRequest.setPrice(new BigDecimal("1"));
		createPaymentRequest.setPaidPrice(new BigDecimal("1.2"));
		createPaymentRequest.setCurrency(Currency.TRY.name());
		createPaymentRequest.setInstallment(1);
		createPaymentRequest.setBasketId("B67832");
		createPaymentRequest.setPaymentChannel(PaymentChannel.WEB.name());
		createPaymentRequest.setPaymentGroup(PaymentGroup.PRODUCT.name());

		PaymentCard card = new PaymentCard();
		card.setCardHolderName(createPaymentRequest.getPaymentCard().getCardHolderName());
		card.setCardNumber(createPaymentRequest.getPaymentCard().getCardNumber());
		card.setExpireMonth(createPaymentRequest.getPaymentCard().getExpireMonth());
		card.setExpireYear(createPaymentRequest.getPaymentCard().getExpireYear());
		card.setCvc(createPaymentRequest.getPaymentCard().getCvc());
		card.setRegisterCard(0);
		createPaymentRequest.setPaymentCard(card);

		Buyer buyer = new Buyer();
		buyer.setId("BY789");
		buyer.setName(createPaymentRequest.getPaymentCard().getCardHolderName());
		buyer.setSurname("surname");
		buyer.setGsmNumber("+905350000000");
		buyer.setEmail("email@email.com");
		buyer.setIdentityNumber("74300864791");
		buyer.setLastLoginDate("2015-10-05 12:43:35");
		buyer.setRegistrationDate("2013-04-21 15:12:09");
		buyer.setRegistrationAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
		buyer.setIp("85.34.78.112");
		buyer.setCity("Istanbul");
		buyer.setCountry("Turkey");
		buyer.setZipCode("34732");
		createPaymentRequest.setBuyer(buyer);

		Address shippingAddress = new Address();
		shippingAddress.setContactName(createPaymentRequest.getShippingAddress().getContactName());
		shippingAddress.setCity(createPaymentRequest.getShippingAddress().getCity());
		shippingAddress.setCountry(createPaymentRequest.getShippingAddress().getCountry());
		shippingAddress.setAddress(createPaymentRequest.getShippingAddress().getAddress());
		shippingAddress.setZipCode(createPaymentRequest.getShippingAddress().getZipCode());
		createPaymentRequest.setShippingAddress(shippingAddress);

		Address billingAddress = new Address();
		billingAddress.setContactName(createPaymentRequest.getShippingAddress().getContactName());
		billingAddress.setCity(createPaymentRequest.getShippingAddress().getCity());
		billingAddress.setCountry(createPaymentRequest.getShippingAddress().getCountry());
		billingAddress.setAddress(createPaymentRequest.getShippingAddress().getAddress());
		billingAddress.setZipCode(createPaymentRequest.getShippingAddress().getZipCode());
		createPaymentRequest.setBillingAddress(billingAddress);

		List<BasketItem> basketItems = new ArrayList<BasketItem>();
		BasketItem firstBasketItem = new BasketItem();
		firstBasketItem.setId("BI101");
		firstBasketItem.setName("Binocular");
		firstBasketItem.setCategory1("Collectibles");
		firstBasketItem.setCategory2("Accessories");
		firstBasketItem.setItemType(BasketItemType.PHYSICAL.name());
		firstBasketItem.setPrice(new BigDecimal("0.3"));
		basketItems.add(firstBasketItem);

		BasketItem secondBasketItem = new BasketItem();
		secondBasketItem.setId("BI102");
		secondBasketItem.setName("Game code");
		secondBasketItem.setCategory1("Game");
		secondBasketItem.setCategory2("Online Game Items");
		secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
		secondBasketItem.setPrice(new BigDecimal("0.5"));
		basketItems.add(secondBasketItem);

		BasketItem thirdBasketItem = new BasketItem();
		thirdBasketItem.setId("BI103");
		thirdBasketItem.setName("Usb");
		thirdBasketItem.setCategory1("Electronics");
		thirdBasketItem.setCategory2("Usb / Cable");
		thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
		thirdBasketItem.setPrice(new BigDecimal("0.2"));
		basketItems.add(thirdBasketItem);
		createPaymentRequest.setBasketItems(basketItems);

		Payment payment = Payment.create(createPaymentRequest, options);
		System.out.println(payment);
		return ResponseEntity
				.ok(new MessageResponse("payment is succesfull you can see the detail on the sandbox page!"));
	}
}
