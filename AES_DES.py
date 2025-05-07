from Cryptodome.Cipher import AES
from secrets import token_bytes
key =b'C&F(H@McQf9TjWZr'
key = token_bytes(16)
cipher = AES.new(key, AES.MODE_EAX)
data = "welcome to the my website".encode()
nonce = cipher.nonce
ciphertext = cipher.encrypt(data)
print("Cipher Text:-",ciphertext)
cipher = AES.new(key,AES.MODE_EAX, nonce = nonce)
plaintext =cipher.decrypt(ciphertext)
plaintext = print("The Plaintext is: ",plaintext)

# DES Algorithm
from Crypto.Cipher import DES
DES_key = token_bytes(8)
def encrypt(msg):
    cipher = DES.new(DES_key, DES.MODE_EAX)
    nonce = cipher.nonce
    ciphertext, tag = cipher.encrypt_and_digest(msg.encode('ascii'))
    return nonce, ciphertext, tag
def decrypt(nonce, ciphertext, tag):
    cipher = DES.new(DES_key, DES.MODE_EAX, nonce=nonce)
    plaintext = cipher.decrypt(ciphertext)
    try:
        cipher.verify(tag)
        return plaintext.decode('ascii')
    except:
        return False
        
nonce, ciphertext, tag = encrypt(input('Enter a message: '))
plaintext = decrypt(nonce, ciphertext, tag)
print(f'Cipher text: {ciphertext}')
if not plaintext:
    print('Message is corrupted!')
else:
    print(f'Plain text: {plaintext}')