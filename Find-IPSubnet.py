def FindMask(IP):
    if (IP[0] < 128):
        return 'A','255.0.0.0'
    elif (IP[0] < 192):
        return 'B','255.255.0.0'
    elif (IP[0] < 224):
        return 'C','255.255.255.0'
    elif (IP[0] < 240):
        return 'D','No'
    elif (IP[0] < 256):
        return 'E','No'
    
def compliment(mask):
    for i in range(4):
        if (mask[i] == 255):
            mask[i]=0
    else:
        mask[i]=255
    return mask
    
def Ipfind(IP,mask):
    FirstIP =[1,2,3,4]
    LastIp = [1,2,3,4]
    for i in range(4):
        FirstIP[i] = IP[i] & mask[i]
    mask = compliment(mask)
    for i in range(4):
        LastIp[i] = IP[i] | mask[i]
    return FirstIP,LastIp

IP = [int(i) for i in input("Enter Ip =").split(".")]

if (len(IP)!=4 or max(IP)>255):
    print("This is Invalid IP or Ip is Out of Range")
else:
    print("This is Valid IP")
    c,mask = FindMask(IP)
    print("Class =", c)
    if (mask == 'No'):
        print("Entered Ip is Reserved")
    else:
        print("Default mask =", mask)
        FirstIP,LastIp = Ipfind(IP,[int(i) for i in mask.split(".")])
        print("FirstIP or Network Address =",".".join(str(i) for i in FirstIP))
        print("LastIp or Host Address =",".".join(str(i) for i in LastIp))
