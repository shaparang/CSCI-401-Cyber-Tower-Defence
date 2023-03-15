import tkinter as tk

# Window Setup
window = tk.Tk()
height, width = window.winfo_screenheight(), window.winfo_screenwidth()
winSize = str(int(width / 2)) + "x" + str(int(height / 2))  # This is a monstrosity
window.geometry(winSize)

# display to hold the graphics
display = tk.Frame(window, bg="blue", height=200, relief="sunken", bd=5)

# user input ui
inputVar = tk.StringVar()
inputText = tk.Entry(window, bg="black", fg="green", bd=5, relief="sunken", font="Ubuntu", textvariable=inputVar)

# text output ui  TODO a text widget can be edited unless we keep changing the state, need to find a better option
consoleText = tk.Text(window, bg="black", fg="green", height=10, bd=5, relief="sunken", font="Ubuntu",)

# layout
display.pack(side="top", fill="both", expand=True)
inputText.pack(side="bottom", fill="x")
consoleText.pack(side="bottom", fill="x")

#keyboard
window.bind("<Return>", lambda x: inputRead())

# feature testing
consoleText.insert(tk.END, "This is a test of the console system\n")
consoleText.insert(tk.END, "The is a second test of the console system\n")

def consoleWrite(input):
    output = input + "\n"
    consoleText.insert(tk.END, output)

def inputRead():
    userInput = inputVar.get()
    consoleWrite(userInput)
    inputText.delete(0, len(userInput))
    return userInput


tk.mainloop()
