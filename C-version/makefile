CC = gcc

CFLAGS = -Wall -g

all: file_runner

file_runner: file_runner.c text_file.c
	$(CC) $(CFLAGS) -o file_runner file_runner.c text_file.c

clean:
	rm -f file_runner
