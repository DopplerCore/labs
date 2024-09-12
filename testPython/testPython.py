from sys import argv
import matplotlib.pyplot as plt
import numpy as np
from mpl_toolkits import mplot3d

fig = plt.figure()
ax = plt.axes(projection='3d')

try:
    script, a = argv
except ValueError:
    a = 0.1

w = [[0.5,0.5]]
T = [0.5]
y = []
S = []
epoxa = 0
goodResults = 0

trainingSample = [
    {
        "x": [1, 1],
        "e": 1,
    },
    {
        "x": [-1, 1],
        "e": -1,
    },
    {
        "x": [-1, -1],
        "e": -1,
    },
    {
        "x": [1, -1],
        "e": 1,
    },
]

isTrained = False
while(not isTrained):
    for el in trainingSample:
        S.append((w[epoxa][0] * el["x"][0] + w[epoxa][1] * el["x"][1]) - T[epoxa]) 
        y.append(-1) if (S[epoxa] < 0) else y.append(1)
        w.append([w[epoxa][0] - a * el["x"][0] * (y[epoxa] - el["e"]), w[epoxa][1] - a * el["x"][1] - a * (y[epoxa] - el["e"])])
        T.append(T[epoxa] + a * (y[epoxa] - el["e"]))
        print(epoxa," ",y[epoxa]," ",el["e"]," ",w[epoxa][0]," ",w[epoxa][1])
        el["id"]=epoxa
        if(y[epoxa] == el["e"]):
            goodResults+=1
        epoxa+=1
    if (goodResults == 4):
        isTrained = True 
    else:
        goodResults = 0


for el in trainingSample:
    ax.scatter3D(el["x"][0],el["x"][1],y[el["id"]])


z = np.arange(-1,1,0.05)
x = np.arange(-1,1,0.05)
xgrid, ygrid = np.meshgrid(x,z)
zgrid = xgrid*w[epoxa-1][0] + ygrid*w[epoxa-1][1]
ax.plot_wireframe(xgrid, ygrid, zgrid)
plt.show()
