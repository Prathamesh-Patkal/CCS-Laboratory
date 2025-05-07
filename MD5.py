#MD5 Algorithm
import hashlib;
str2hash="Welcome to sanjivani"
result= hashlib.md5(str2hash.encode())
print("the hash code of MD:", end="")
print(result.hexdigest())