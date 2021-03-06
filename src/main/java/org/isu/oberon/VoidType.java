package org.isu.oberon;

import org.bytedeco.javacpp.LLVM;

import static org.bytedeco.javacpp.LLVM.LLVMInt64Type;

public class VoidType extends TypeSymbol {
    public VoidType() {
        super("@VOID@");
    }

    @Override
    protected LLVM.LLVMValueRef genConstant(Context c) {
        return genConstant(c,"");
    }

    @Override
    protected LLVM.LLVMValueRef genConstant(Context c, String value) {
        // FIXME: issue an exception on using void type value.
        System.err.println("WARNING: usage of void type reference");
        return null;
    }

    @Override
    protected LLVM.LLVMTypeRef genRef() {
        return LLVMInt64Type();
    }
}
