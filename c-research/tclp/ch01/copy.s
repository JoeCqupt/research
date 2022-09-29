	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 11, 0	sdk_version 12, 0
	.globl	_main                           ; -- Begin function main
	.p2align	2
_main:                                  ; @main
	.cfi_startproc
; %bb.0:
	sub	sp, sp, #96                     ; =96
	stp	x29, x30, [sp, #80]             ; 16-byte Folded Spill
	add	x29, sp, #80                    ; =80
	.cfi_def_cfa w29, 16
	.cfi_offset w30, -8
	.cfi_offset w29, -16
	stur	wzr, [x29, #-4]
	adrp	x8, l_.str@PAGE
	add	x8, x8, l_.str@PAGEOFF
	stur	x8, [x29, #-16]
	adrp	x8, l_.str.1@PAGE
	add	x8, x8, l_.str.1@PAGEOFF
	stur	x8, [x29, #-24]
	ldur	x0, [x29, #-16]
	adrp	x1, l_.str.2@PAGE
	add	x1, x1, l_.str.2@PAGEOFF
	bl	_fopen
	stur	x0, [x29, #-32]
	ldur	x8, [x29, #-32]
	cbnz	x8, LBB0_2
; %bb.1:
	adrp	x0, l_.str.3@PAGE
	add	x0, x0, l_.str.3@PAGEOFF
	bl	_printf
	mov	w0, #1
	bl	_exit
LBB0_2:
	ldur	x0, [x29, #-24]
	adrp	x1, l_.str.4@PAGE
	add	x1, x1, l_.str.4@PAGEOFF
	bl	_fopen
	str	x0, [sp, #40]
	ldr	x8, [sp, #40]
	cbnz	x8, LBB0_4
; %bb.3:
	adrp	x0, l_.str.5@PAGE
	add	x0, x0, l_.str.5@PAGEOFF
	bl	_printf
	mov	w0, #1
	bl	_exit
LBB0_4:
	mov	w8, #1024
	str	w8, [sp, #36]
	ldrsw	x0, [sp, #36]
	bl	_malloc
	str	x0, [sp, #24]
	str	xzr, [sp, #16]
LBB0_5:                                 ; =>This Inner Loop Header: Depth=1
	ldr	x0, [sp, #24]
	ldrsw	x2, [sp, #36]
	ldur	x3, [x29, #-32]
	mov	x1, #1
	bl	_fread
	str	x0, [sp, #16]
	subs	x8, x0, #0                      ; =0
	b.ls	LBB0_11
; %bb.6:                                ;   in Loop: Header=BB0_5 Depth=1
	ldr	x0, [sp, #24]
	ldr	x2, [sp, #16]
	ldr	x3, [sp, #40]
	mov	x1, #1
	bl	_fwrite
	str	x0, [sp, #8]
	ldr	x8, [sp, #8]
	ldr	x9, [sp, #16]
	subs	x8, x8, x9
	b.eq	LBB0_10
; %bb.7:                                ;   in Loop: Header=BB0_5 Depth=1
	ldr	x0, [sp, #40]
	bl	_ferror
	cbz	w0, LBB0_9
; %bb.8:                                ;   in Loop: Header=BB0_5 Depth=1
	adrp	x0, l_.str.6@PAGE
	add	x0, x0, l_.str.6@PAGEOFF
	bl	_printf
LBB0_9:                                 ;   in Loop: Header=BB0_5 Depth=1
LBB0_10:                                ;   in Loop: Header=BB0_5 Depth=1
	b	LBB0_5
LBB0_11:
	ldur	x0, [x29, #-32]
	bl	_feof
	cbz	w0, LBB0_13
; %bb.12:
	adrp	x0, l_.str.7@PAGE
	add	x0, x0, l_.str.7@PAGEOFF
	bl	_printf
	b	LBB0_16
LBB0_13:
	ldur	x0, [x29, #-32]
	bl	_ferror
	cbz	w0, LBB0_15
; %bb.14:
	adrp	x0, l_.str.8@PAGE
	add	x0, x0, l_.str.8@PAGEOFF
	bl	_printf
	mov	w0, #1
	bl	_exit
LBB0_15:
LBB0_16:
	ldr	x0, [sp, #24]
	bl	_free
	ldur	x0, [x29, #-32]
	bl	_fclose
	ldr	x0, [sp, #40]
	bl	_fclose
	mov	w0, #0
	ldp	x29, x30, [sp, #80]             ; 16-byte Folded Reload
	add	sp, sp, #96                     ; =96
	ret
	.cfi_endproc
                                        ; -- End function
	.section	__TEXT,__cstring,cstring_literals
l_.str:                                 ; @.str
	.asciz	"a.txt"

l_.str.1:                               ; @.str.1
	.asciz	"b.txt"

l_.str.2:                               ; @.str.2
	.asciz	"rb"

l_.str.3:                               ; @.str.3
	.asciz	"open source file fail."

l_.str.4:                               ; @.str.4
	.asciz	"wb+"

l_.str.5:                               ; @.str.5
	.asciz	"open dist file fail."

l_.str.6:                               ; @.str.6
	.asciz	"write dist file fail."

l_.str.7:                               ; @.str.7
	.asciz	"success copy"

l_.str.8:                               ; @.str.8
	.asciz	"read source file fail."

.subsections_via_symbols
