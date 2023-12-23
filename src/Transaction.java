import java.math.BigInteger;
public class Transaction {
    private BigInteger senderMessage;
    private BigInteger encryptedMessage;
    private BigInteger signature;

    public Transaction(BigInteger senderMessage, BigInteger encryptedMessage, BigInteger signature) {
        this.senderMessage = senderMessage;
        this.encryptedMessage = encryptedMessage;
        this.signature = signature;
    }
    public BigInteger getSenderMessage(){
        return senderMessage;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "senderMessage=" + senderMessage +
                ", encryptedMessage=" + encryptedMessage +
                ", signature=" + signature +
                '}';
    }
}

