package com.rzk.RitzyGoat;

/*
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/*
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
import com.rzk.RitzyGoat.business.concretes.PaymentCardManager;
*/
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RitzyGoatApplication {

	public static void main(String[] args) {

		SpringApplication.run(RitzyGoatApplication.class, args);

		/*
		 * Options options=new Options();
		 * options.setApiKey("sandbox-cvFrl3qL0KWtBBOpXC417rqGuqYRn66I");
		 * options.setSecretKey("sandbox-CpQT5aLprYsaruwFa6SMIplRNmbhlNDM");
		 * options.setBaseUrl("https://sandbox-api.iyzipay.com");
		 * 
		 * CreatePaymentRequest request = new CreatePaymentRequest();
		 * request.setLocale(Locale.TR.getValue());
		 * request.setConversationId("123456789"); request.setPrice(new
		 * BigDecimal("1")); request.setPaidPrice(new BigDecimal("1.2"));
		 * request.setCurrency(Currency.TRY.name()); request.setInstallment(1);
		 * request.setBasketId("B67832");
		 * request.setPaymentChannel(PaymentChannel.WEB.name());
		 * request.setPaymentGroup(PaymentGroup.PRODUCT.name());
		 * 
		 * PaymentCard paymentCard = new PaymentCard();
		 * paymentCard.setCardHolderName("sansa stark");
		 * paymentCard.setCardNumber("4987490000000002");
		 * paymentCard.setExpireMonth("12"); paymentCard.setExpireYear("2030");
		 * paymentCard.setCvc("123"); paymentCard.setRegisterCard(0);
		 * request.setPaymentCard(paymentCard);
		 * 
		 * Buyer buyer = new Buyer(); buyer.setId("BY789"); buyer.setName("sansa");
		 * buyer.setSurname("stark"); buyer.setGsmNumber("+905350000000");
		 * buyer.setEmail("email@email.com"); buyer.setIdentityNumber("74300864791");
		 * buyer.setLastLoginDate("2015-10-05 12:43:35");
		 * buyer.setRegistrationDate("2013-04-21 15:12:09"); buyer.
		 * setRegistrationAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
		 * buyer.setIp("85.34.78.112"); buyer.setCity("Istanbul");
		 * buyer.setCountry("Turkey"); buyer.setZipCode("34732");
		 * request.setBuyer(buyer);
		 * 
		 * Address shippingAddress = new Address();
		 * shippingAddress.setContactName("Jane Doe");
		 * shippingAddress.setCity("Istanbul"); shippingAddress.setCountry("Turkey");
		 * shippingAddress.
		 * setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
		 * shippingAddress.setZipCode("34742");
		 * request.setShippingAddress(shippingAddress);
		 * 
		 * Address billingAddress = new Address();
		 * billingAddress.setContactName("Jane Doe");
		 * billingAddress.setCity("Istanbul"); billingAddress.setCountry("Turkey");
		 * billingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1"
		 * ); billingAddress.setZipCode("34742");
		 * request.setBillingAddress(billingAddress);
		 * 
		 * List<BasketItem> basketItems = new ArrayList<BasketItem>(); BasketItem
		 * firstBasketItem = new BasketItem(); firstBasketItem.setId("BI101");
		 * firstBasketItem.setName("Binocular");
		 * firstBasketItem.setCategory1("Collectibles");
		 * firstBasketItem.setCategory2("Accessories");
		 * firstBasketItem.setItemType(BasketItemType.PHYSICAL.name());
		 * firstBasketItem.setPrice(new BigDecimal("0.3"));
		 * basketItems.add(firstBasketItem);
		 * 
		 * BasketItem secondBasketItem = new BasketItem();
		 * secondBasketItem.setId("BI102"); secondBasketItem.setName("Game code");
		 * secondBasketItem.setCategory1("Game");
		 * secondBasketItem.setCategory2("Online Game Items");
		 * secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
		 * secondBasketItem.setPrice(new BigDecimal("0.5"));
		 * basketItems.add(secondBasketItem);
		 * 
		 * BasketItem thirdBasketItem = new BasketItem();
		 * thirdBasketItem.setId("BI103"); thirdBasketItem.setName("Usb");
		 * thirdBasketItem.setCategory1("Electronics");
		 * thirdBasketItem.setCategory2("Usb / Cable");
		 * thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
		 * thirdBasketItem.setPrice(new BigDecimal("0.2"));
		 * basketItems.add(thirdBasketItem); request.setBasketItems(basketItems);
		 * 
		 * Payment payment = Payment.create(request, options);
		 * 
		 * System.out.println(payment);
		 */
	}

	/*
	 * @Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
	 * }
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rzk.RitzyGoat")).build();
	}

}
