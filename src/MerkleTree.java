import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
public class MerkleTree {
    private List<String> leaves;

    public MerkleTree(List<String> leaves) {
        this.leaves = leaves;
    }

    public String buildTree() {
        List<String> currentLevel = new ArrayList<>(leaves);

        while (currentLevel.size() > 1) {
            List<String> nextLevel = new ArrayList<>();

            for (int i = 0; i < currentLevel.size(); i += 2) {
                String left = currentLevel.get(i);
                String right = (i + 1 < currentLevel.size()) ? currentLevel.get(i + 1) : left;

                String combinedHash = calculateHash(left + right);
                nextLevel.add(combinedHash);
            }

            currentLevel = nextLevel;
        }

        return currentLevel.get(0);
    }

    private String calculateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());
            return String.format("%064x", new BigInteger(1, hashBytes));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}