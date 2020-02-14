# MicrometerPoc
Simple Poc using micrometer basic functionalities.
Send a POST request to the localhost:8080/message URI with a JSON body like this:

>{
	"text":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
}

Micrometer will register meters for each message sent, and the total number of characters of all the messages registered and print the metrics in the terminal!
