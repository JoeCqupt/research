CORE_DEPS = src/core.h src/repl.h src/config.h src/parser.h src/executor.h
CORE_INCS = -I src/

.PHONY: build
build: objs/repl.o objs/parser.o objs/executor.o $(CORE_DEPS) src/simple-db2.c
	gcc $(CORE_INCS) -o simple-db2 objs/repl.o objs/parser.o objs/executor.o src/simple-db2.c


objs/repl.o: $(CORE_DEPS) src/repl.c
	gcc -c $(CORE_INCS) -o objs/repl.o src/repl.c

objs/parser.o: $(CORE_DEPS) src/parser.c
	gcc -c $(CORE_INCS) -o objs/parser.o src/parser.c

objs/executor.o: $(CORE_DEPS) src/executor.c
	gcc -c $(CORE_INCS) -o objs/executor.o src/executor.c

.PHONY: clean
clean: 
	rm -rf simple-db2 objs/*.o