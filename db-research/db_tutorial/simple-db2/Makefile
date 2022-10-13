CORE_DEPS = src/core.h src/repl.h src/config.h src/parser.h src/executor.h src/storage.h
CORE_INCS = -I src/

CFLAGS= -g

build: objs/repl.o objs/parser.o objs/executor.o objs/storage.o $(CORE_DEPS) src/simple-db2.c
	gcc $(CORE_INCS) $(CFLAGS) -o simple-db2 objs/repl.o objs/parser.o objs/executor.o objs/storage.o src/simple-db2.c


objs/repl.o: $(CORE_DEPS) src/repl.c
	gcc -c $(CORE_INCS) $(CFLAGS) -o objs/repl.o src/repl.c

objs/parser.o: $(CORE_DEPS) src/parser.c
	gcc -c $(CORE_INCS) $(CFLAGS) -o objs/parser.o src/parser.c

objs/executor.o: $(CORE_DEPS) src/executor.c
	gcc -c $(CORE_INCS) $(CFLAGS) -o objs/executor.o src/executor.c

objs/storage.o: $(CORE_DEPS) src/storage.c
	gcc -c $(CORE_INCS) $(CFLAGS) -o objs/storage.o src/storage.c

.PHONY: clean
clean: 
	rm -rf simple-db2 objs/*.o test.out


test:  objs/repl.o objs/parser.o objs/executor.o objs/storage.o $(CORE_DEPS) test/test.c
	gcc $(CORE_INCS) $(CFLAGS) -o test.out objs/repl.o objs/parser.o objs/executor.o objs/storage.o test/test.c