package soap;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import wsdl.CheckCCResponse;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CheckerConfiguration.class, args);

        CardChecker checker = ctx.getBean(CardChecker.class);

        CheckCCResponse response = checker.add("4111111111111111");
        checker.printResponse(response);
    }

}
