CC := javac
CFLAGS :=
SRC := $(wildcard *.java)
OBJ := $(patsubst %.java, %.class, $(SRC))
MAIN := Gfx2d

.PHONY : all clean rebuild

all : $(OBJ)

%.class : %.java
	$(CC) $(CFLAGS) $<

clean :
	\rm -f $(OBJ)

rebuild :
	make clean
	make all
