package org.eclipse.jdt.internal.codeassist.complete;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
/*
 * Completion node build by the parser in any case it was intending to
 * reduce a type reference containing the completion identifier as a single
 * name reference.
 * e.g.
 *
 *	class X extends Obj[cursor]
 *
 *	---> class X extends <CompleteOnType:Obj>
 *
 * The source range of the completion node denotes the source range
 * which should be replaced by the completion.
 */
 
import org.eclipse.jdt.internal.compiler.ast.*;
import org.eclipse.jdt.internal.compiler.lookup.*;

public class CompletionOnSingleTypeReference extends SingleTypeReference {
public boolean isCompletionNode;
public CompletionOnSingleTypeReference(char[] source, long pos) {
	super(source, pos);
	isCompletionNode = true;
}
public void aboutToResolve(Scope scope) {
	getTypeBinding(scope);
}
/*
 * No expansion of the completion reference into an array one
 */
public TypeReference copyDims(int dim){
	return this;
}
public TypeBinding getTypeBinding(Scope scope) {
	if(isCompletionNode) {
		throw new CompletionNodeFound(this, scope);
	} else {
		return super.getTypeBinding(scope);
	}
}
public TypeBinding resolveTypeEnclosing(BlockScope scope, ReferenceBinding enclosingType) {
	if(isCompletionNode) {
		throw new CompletionNodeFound(this, enclosingType, scope);
	} else {
		return super.resolveTypeEnclosing(scope, enclosingType);
	}
}
public String toStringExpression(int tab){

	return "<CompleteOnType:" + new String(token) + ">" ; //$NON-NLS-2$ //$NON-NLS-1$
}
}
