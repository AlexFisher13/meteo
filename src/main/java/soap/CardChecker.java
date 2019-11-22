package soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import wsdl.*;

public class CardChecker extends WebServiceGatewaySupport {

    public CheckCCResponse add(String cardNumber) {
        CheckCC request = new CheckCC();
        request.setCardNumber(cardNumber);

        System.out.println("Requesting for " + cardNumber);

        CheckCCResponse response = (CheckCCResponse) getWebServiceTemplate().marshalSendAndReceive(request,
                new SoapActionCallback("http://ws.cdyne.com/CheckCC"));

        return response;
    }

    public void printResponse(CheckCCResponse response) {
        System.out.println("Response: Card activity is " + response.getCheckCCResult().isCardValid() +
                ". Card type: " + response.getCheckCCResult().getCardType());
    }

}
