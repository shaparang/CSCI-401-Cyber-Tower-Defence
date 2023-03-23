import tkinter as tk

class Window:
    global display

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

    # text output ui
    consoleText = tk.Text(window, bg="black", fg="green", height=10, bd=5, relief="sunken", font="Ubuntu",
                          state="disabled")

    # layout
    display.pack(side="top", fill="both", expand=True)
    inputText.pack(side="bottom", fill="x")
    consoleText.pack(side="bottom", fill="x")

    # keyboard binds
    enter = tk.IntVar()
    window.bind('<Return>', enter.set(1))
    def console_clear(self, lines):
        self.consoleText.delete(1.0, lines)

    def console_write(self, input):
        self.consoleText.config(state="normal")
        output = input + "\n"
        self.consoleText.insert(tk.END, output)
        self.consoleText.config(state="disabled")

    def input_read(self):
        self.inputText.wait_variable(self.enter)
        userInput = self.inputVar.get()
        self.console_write(userInput)
        self.inputText.delete(0, len(userInput))
        self.enter.set(0)
        return userInput


main = Window()

main.console_write("this is a test")
var = main.input_read()
main.console_write(var)

tk.mainloop()