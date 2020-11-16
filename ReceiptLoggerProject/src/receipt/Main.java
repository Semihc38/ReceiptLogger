package receipt;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	ReceiptLogger getReceiptLogger = new ReceiptLogger();
	getReceiptLogger.receipt();
    }
}
