import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecureTransaction {
    private List<Block> blockchain;
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public SecureTransaction(){
        blockchain = new ArrayList<>();
    }

    // Key generation
    public void generateKeys(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = new BigInteger(bitLength, 100, random);
        BigInteger q = new BigInteger(bitLength, 100, random);

        modulus = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        publicKey = new BigInteger("65537"); // Common public exponent
        privateKey = publicKey.modInverse(phi);
    }

    // Encrypt message
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    // Sign message
    public BigInteger sign(BigInteger message) {
        return message.modPow(privateKey, modulus);
    }

    // Verify signature
    public boolean verify(BigInteger message, BigInteger signature) {
        BigInteger recoveredMessage = signature.modPow(publicKey, modulus);
        return message.equals(recoveredMessage);
    }

    // Decrypt message
    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(privateKey, modulus);
    }

    // Method to add a block to the blockchain
    public void addBlock(List<Transaction> transactions) {
        String previousHash = (blockchain.isEmpty()) ? "0" : blockchain.get(blockchain.size() - 1).getHash();
        Block newBlock = new Block(transactions, previousHash);
        blockchain.add(newBlock);
    }

    // Method to display the blockchain
    public void displayBlockchain() {
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }

    // Method to hash a message
    public String hashMessage(BigInteger data) throws NoSuchAlgorithmException {
        byte[] dataBytes = data.toByteArray();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(dataBytes);
        String hexHash = String.format("%064x", new BigInteger(1, hash));
        return hexHash;
    }

}