import hashlib;
str2hash="Welcome to sanjivani"
result= hashlib.sha1(str2hash.encode())
print("the hash code of SHA-1:", end="")
print(result.hexdigest())