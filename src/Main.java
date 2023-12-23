import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureTransaction secureTransaction = new SecureTransaction();
        List<Transaction> transactions = new ArrayList<>();
        List<String> transactionHashes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Hello to SecureTransaction network. There you can sent money to your friend.");
            System.out.println("1) Send money");
            System.out.println("2) Watch Blockchain");
            System.out.println("3) Watch MerkleRoot");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("What amount of money you want to send?");
                    BigInteger senderMessage = scanner.nextBigInteger();
                    System.out.println("Are you sure? Sign the transaction if Yes.");
                    System.out.println("1)Sign 2)Cancel");
                    int choice1 = scanner.nextInt();
                    if (choice1 == 1) {
                        secureTransaction.generateKeys(1024);
                        BigInteger encryptedSenderMessage = secureTransaction.encrypt(senderMessage);
                        BigInteger signatureSender = secureTransaction.sign(senderMessage);
                        Transaction transaction = new Transaction(senderMessage, encryptedSenderMessage, signatureSender);
                        transactions.add(transaction);
                        secureTransaction.addBlock(transactions);
                        System.out.println("Transaction successfully.");
                    }
                    else break;
                    break;
                case 2:
                    secureTransaction.displayBlockchain();
                    break;
                case 3:
                    for (Transaction tx : transactions) {
                        String transactionHash = secureTransaction.hashMessage(tx.getSenderMessage());
                        transactionHashes.add(transactionHash);
                    }

                    MerkleTree merkleTree = new MerkleTree(transactionHashes);
                    String merkleRoot = merkleTree.buildTree();

                    System.out.println("Merkle Root: " + merkleRoot);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }
}