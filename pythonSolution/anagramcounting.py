import sys

for name in sys.stdin:
    try:
        #name=list(input())
        name=list(name)
        if("'" in name):
            name.remove("'")
        if("'" in name):
            name.remove("'")
        
        if('\r' in name):
            name.remove('\r')
        if('\n' in name):
            name.remove('\n')
        line = len(name)
        t,elem,val=[1],[],[]
        elem=[]
        s=1
        for i in range (1,line+1):
            s=s*i
            t=t+[s,]
            if(name[i-1] in elem):
                val[elem.index(name[i-1],0,len(val))]+=1
            else:
                elem.append(name[i-1])
                val=val+[1,]
        v=1
        for i in range (len(val)):
            v=v*t[val[i]]
        print(s/v)
        
    except EOFError:
        break
