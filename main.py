import tkinter as tk

# Window Setup
window = tk.Tk()
height, width = window.winfo_screenheight(), window.winfo_screenwidth()
winSize = str(int(width / 2)) + "x" + str(int(height / 2))  # This is a monstrosity
window.geometry(winSize)
# TODO once all ui elements are in the window, grid seems better than pack in the long run

# user input ui
inputVar = tk.StringVar()
inputText = tk.Entry(window, bg="black", fg="green", bd=5, relief="sunken", font="Ubuntu", textvariable=inputVar)
inputText.pack(side="bottom", fill="x")


# text output ui  TODO a text widget can be edited unless we keep changing the state, need to find a better option
consoleText = tk.Text(window, bg="black", fg="green", height=10, bd=5, relief="sunken", font="Ubuntu")
consoleText.pack(side="bottom", fill="x")

# feature testing
consoleText.insert(tk.END, "This is a test of the console system\n")
consoleText.insert(tk.END, "The is a second test of the console system ")


tk.mainloop()
