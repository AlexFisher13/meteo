package soap;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import wsdl.CheckCCResponse;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CheckerConfiguration.class, args);

        CardChecker checker = ctx.getBean(CardChecker.class);

        CheckCCResponse response = checker.add("231");
        checker.printResponse(response);
    }

}
