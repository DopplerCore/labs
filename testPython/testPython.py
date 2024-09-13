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

epoxa -=1
x1 = np.linspace(-1, 1, 5)
x2 = np.linspace(-1, 1, 5)
x1grid, x2grid = np.meshgrid(x1,x2)
T1 = [T[epoxa],T[epoxa],T[epoxa],T[epoxa],T[epoxa]]
ygrid = x1grid*w[epoxa][0] + x2grid*w[epoxa][1] - T1
ax.plot_wireframe(x1grid, x2grid, ygrid)
y0grid =  ygrid*0
ax.plot_wireframe(x1grid, x2grid, y0grid, color="red")


y = np.linspace(-1, 1, 5)
x1grid, ygrid = np.meshgrid(x1,y)
x2grid = (T1 - x1grid * w[epoxa][0]) / w[epoxa][1]
ax.plot_wireframe(x1grid, x2grid, ygrid, color="green")




ax.set_xlabel('x1', fontsize=12)
ax.set_ylabel('x2', fontsize=12)
ax.set_zlabel('y', fontsize=12)
plt.show()
