# Blockchain application
# Assigment 1
# Course: Blockchain Technologies 1
---

## Tasks from
- [Assignment 1]([https://moodle.astanait.edu.kz/mod/assign/view.php?id=106863])

## Build
IntelliJ IDEA
- I used v2022.3.1
## Explanation of the Assignment 1

---
<details>
<summary>-Class: SecureTransaction</summary>

The SecureTransaction class provides essential cryptographic functionality for secure transactions, including key generation, encryption, signature creation and verification, decryption, and blockchain management.

-Constructors:

SecureTransaction()
Initializes an instance of SecureTransaction with an empty list for the blockchain.

-Methods:

1)generateKeys(int bitLength)
Generates public and private keys based on the specified bit length.

2)encrypt(BigInteger message) -> BigInteger
Encrypts the given message using the public key and modulus.

3)sign(BigInteger message) -> BigInteger
Signs the given message using the private key and modulus.

4)verify(BigInteger message, BigInteger signature) -> boolean
Verifies the signature of a message using the public key.

5)decrypt(BigInteger ciphertext) -> BigInteger
Decrypts the given ciphertext using the private key and modulus.

6)addBlock(List<Transaction> transactions)
Adds a new block to the blockchain, incorporating the provided list of transactions. Uses the previous block's hash for linkage.

7)displayBlockchain()
Displays the entire blockchain by iterating through each block and printing its details.

8)hashMessage(BigInteger data) throws NoSuchAlgorithmException -> String
Hashes the provided BigInteger data using the SHA-256 algorithm and returns the hexadecimal representation of the hash.
</details>
<details>
<summary>-Class: Block</summary>

The Block class represents a block in the blockchain, containing a list of transactions, the hash of the previous block, and its own hash. 

-Constructors:

Block(List<Transaction> transactions, String previousHash)
Initializes a new block with the given list of transactions and the hash of the previous block.

-Methods:

1)calculateHash() -> String
Calculates the hash of the block by concatenating the previous hash and the string representation of the transactions.
Uses the SHA-256 algorithm for hashing.
Returns the hexadecimal representation of the hash.

2)getHash() -> String
Returns the hash of the current block.

3)toString() -> String
Provides a string representation of the block, including details about its transactions, previous hash, and current hash.
</details>
<details>
<summary>-Class: Transaction</summary>

The Transaction class represents a single transaction within the secure transaction system. It encapsulates the sender's original message, the encrypted message for secure transmission, and the digital signature.

-Constructors:

Transaction(BigInteger senderMessage, BigInteger encryptedMessage, BigInteger signature)
Initializes a new transaction with the specified sender message, encrypted message, and signature.

-Methods:

1)getSenderMessage() -> BigInteger
Returns the original sender message.

2)toString() -> String
Provides a string representation of the transaction, including details about the sender message, encrypted message, and signature.
</details>
<details>
<summary>-Class: MerkleTree</summary>

The MerkleTree class represents a Merkle tree used to create a tamper-proof structure of transaction hashes. The tree is built iteratively by combining adjacent hashes until a single root hash is obtained.

-Constructors:

MerkleTree(List<String> leaves)
Initializes a Merkle tree with the provided list of leaves (transaction hashes).

-Methods:

1)buildTree() -> String
Builds the Merkle tree iteratively until a single root hash is obtained.
Returns the root hash of the Merkle tree.

2)calculateHash(String data) -> String
Calculates the SHA-256 hash of the given data and returns the hexadecimal representation.
</details>
