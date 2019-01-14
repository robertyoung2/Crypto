# Crypto
Methods for encrypting and decrypting text written in Java. Designed using the Rubic from the Microsoft course DEV276x, Project 3.

The code can both encrypt and decrypt text using an obify technique and the caesar cypher. 

My coded implementation may be seen [here](https://github.com/robertyoung2/Crypto/blob/master/src/Crypto.java).

The project is broken up into the following parts:

### Part 1 - Normalise Text

Method *normaliseText* to normalise text. This method works as follows:

1. Removes all the spaces from the text.
2. Removess any punctuation (. , : ; ’ ” ! ? ( ) ).
3. Turns all lower-case letters into upper-case letters.
4. Returns the result.

### Part 2 - Obify and Caesar Cipher

The *obify* method obfuscates the normalised text by adding the characters "OB" in front of any vowel present in the normalised text. In this implementation 'y' is considered a vowel.

Method caesarify that takes two parameters. The first argument is a string to encrypt, and the second is an integer that contains the shift value or "key". The function returns a string, which is the input string encrypted with the Caesar cypher using the shift value passed in its second argument. The input string has been normalized and obfuscated.

### Part 3 - Codegroups

Encrypted messages are broken into equal-length chunks, separated by spaces and called “code groups.” The method *groupify* returns a string, which consists of the input string broken into groups with number of letters specified by the second arguement. If there are not enough letters in the input string to fill out all the groups, the final group is “padded” with lowercase x’s.

### Part 4 - Putting it all together

The function called *encryptString*  takes three parameters: a string to be encrypted, an integer shift value, and a code group size. The method returns a string which is its cyphertext equivalent. The function does the following:

- Calls normalizeText on the input string.
- Calls obify to obfuscate the normalized text.
- Calls caesarify to encrypt the obfuscated text.
- Calls groupify to break the cyphertext into groups of size letters.
- Returns the result.

### Part 5 - Hacker Problem - Decrypt

This is a bonus section for the project. A new method, *decryptString*, has been created wich can decrypt encrypted text.
