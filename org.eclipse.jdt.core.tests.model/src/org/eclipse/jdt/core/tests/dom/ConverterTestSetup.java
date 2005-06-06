/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.core.tests.dom;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.tests.util.Util;

public abstract class ConverterTestSetup extends AbstractASTTests {

	/** @deprecated Using deprecated code */
	public static final int AST_INTERNAL_JLS2 = AST.JLS2;
	
	protected AST ast;
	static List TEST_SUITES = null;
	static boolean PROJECT_SETUP = false;

	protected ConverterTestSetup(String name) {
		super(name);
	}

	protected IPath getConverterJCLPath() {
		return getConverterJCLPath(""); //$NON-NLS-1$
	}

	protected IPath getConverterJCLPath(String compliance) {
		return new Path(getExternalPath() + "converterJclMin" + compliance + ".jar"); //$NON-NLS-1$
	}

	protected IPath getConverterJCLSourcePath() {
		return getConverterJCLSourcePath(""); //$NON-NLS-1$
	}

	protected IPath getConverterJCLSourcePath(String compliance) {
		return new Path(getExternalPath() + "converterJclMin" + compliance + "src.zip"); //$NON-NLS-1$
	}

	protected IPath getConverterJCLRootSourcePath() {
		return new Path(""); //$NON-NLS-1$
	}

	/**
	 * Reset the jar placeholder and delete project.
	 */
	public void tearDownSuite() throws Exception {
		ast = null;
		if (TEST_SUITES == null) {
			this.deleteProject("Converter"); //$NON-NLS-1$
			this.deleteProject("Converter15"); //$NON-NLS-1$
		} else {
			TEST_SUITES.remove(getClass());
			if (TEST_SUITES.size() == 0) {
				this.deleteProject("Converter"); //$NON-NLS-1$
				this.deleteProject("Converter15"); //$NON-NLS-1$
			}
		}
		
		super.tearDown();
	}	

	public void setUpJCLClasspathVariables(String compliance) throws JavaModelException, IOException {
		if ("1.5".equals(compliance)) {
			if (JavaCore.getClasspathVariable("CONVERTER_JCL15_LIB") == null) {
				setupExternalJCL("converterJclMin1.5");
				JavaCore.setClasspathVariables(
					new String[] {"CONVERTER_JCL15_LIB", "CONVERTER_JCL15_SRC", "CONVERTER_JCL15_SRCROOT"},
					new IPath[] {getConverterJCLPath(compliance), getConverterJCLSourcePath(compliance), getConverterJCLRootSourcePath()},
					null);
			} 
		} else {
			if (JavaCore.getClasspathVariable("CONVERTER_JCL_LIB") == null) {
				setupExternalJCL("converterJclMin");
				JavaCore.setClasspathVariables(
					new String[] {"CONVERTER_JCL_LIB", "CONVERTER_JCL_SRC", "CONVERTER_JCL_SRCROOT"},
					new IPath[] {getConverterJCLPath(), getConverterJCLSourcePath(), getConverterJCLRootSourcePath()},
					null);
			} 
		}	
	}
	
	/**
	 * Create project and set the jar placeholder.
	 */
	public void setUpSuite() throws Exception {
		super.setUpSuite();

		if (!PROJECT_SETUP) {
			setUpJavaProject("Converter"); //$NON-NLS-1$
			setUpJavaProject("Converter15", "1.5"); //$NON-NLS-1$ //$NON-NLS-2$
			PROJECT_SETUP = true;
		}
	}

	public ASTNode runConversion(ICompilationUnit unit, boolean resolveBindings) {
		return runConversion(AST_INTERNAL_JLS2, unit, resolveBindings);
	}

	public ASTNode runConversion(ICompilationUnit unit, int position, boolean resolveBindings) {
		return runConversion(AST_INTERNAL_JLS2, unit, position, resolveBindings);
	}

	public ASTNode runConversion(IClassFile classFile, int position, boolean resolveBindings) {
		return runConversion(AST_INTERNAL_JLS2, classFile, position, resolveBindings);
	}
	
	public ASTNode runConversion(char[] source, String unitName, IJavaProject project) {
		return runConversion(AST_INTERNAL_JLS2, source, unitName, project);
	}
	
	public ASTNode runConversion(int astLevel, ICompilationUnit unit, boolean resolveBindings) {
		ASTParser parser = ASTParser.newParser(astLevel);
		parser.setSource(unit);
		parser.setResolveBindings(resolveBindings);
		return parser.createAST(null);
	}

	class NullBindingVerifier extends ASTVisitor {

		public void endVisit(ArrayAccess node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(ArrayCreation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(ArrayInitializer node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(Assignment node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(BooleanLiteral node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(CastExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(CharacterLiteral node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(ClassInstanceCreation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(ConditionalExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(FieldAccess node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(InfixExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(InstanceofExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(MarkerAnnotation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(MethodInvocation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(NormalAnnotation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(NullLiteral node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(NumberLiteral node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(ParenthesizedExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(PostfixExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(PrefixExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(SingleMemberAnnotation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(StringLiteral node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(SuperFieldAccess node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(SuperMethodInvocation node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(ThisExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(TypeLiteral node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(VariableDeclarationExpression node) {
			assertNotNull(node+" should have a binding", node.resolveTypeBinding());
			super.endVisit(node);
		}

		public void endVisit(AnnotationTypeDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(AnnotationTypeMemberDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(AnonymousClassDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(ArrayType node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(EnumDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(ImportDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(MemberRef node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(MethodDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(MethodRef node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(PackageDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(ParameterizedType node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(PrimitiveType node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(QualifiedName node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(QualifiedType node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(SimpleName node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(SimpleType node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(SingleVariableDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(TypeDeclaration node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(TypeDeclarationStatement node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(TypeParameter node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(VariableDeclarationFragment node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

		public void endVisit(WildcardType node) {
			assertNotNull(node+" should have a binding", node.resolveBinding());
			super.endVisit(node);
		}

	}
	public ASTNode runJLS3Conversion(ICompilationUnit unit, boolean resolveBindings, boolean checkJLS2) {

		// Create parser
		ASTParser parser;
		if (checkJLS2) {
			parser = ASTParser.newParser(AST_INTERNAL_JLS2);
			parser.setSource(unit);
			parser.setResolveBindings(resolveBindings);
			parser.createAST(null);
		}
		
		parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(unit);
		parser.setResolveBindings(resolveBindings);
		
		// Parse compilation unit
		ASTNode result = parser.createAST(null);
		
		// Verify we get a compilation unit node and that binding are correct
		assertTrue("Not a compilation unit", result.getNodeType() == ASTNode.COMPILATION_UNIT);
		CompilationUnit compilationUnit = (CompilationUnit) result;
		if (resolveBindings && compilationUnit.getProblems().length == 0) {
			compilationUnit.accept(new NullBindingVerifier());
		}
		return result;
	}
	
	public ASTNode runConversion(int astLevel, ICompilationUnit unit, int position, boolean resolveBindings) {

		// Create parser
		ASTParser parser = ASTParser.newParser(astLevel);
		parser.setSource(unit);
		parser.setFocalPosition(position);
		parser.setResolveBindings(resolveBindings);

		// Parse compilation unit
		ASTNode result = parser.createAST(null);
		
		// Verify we get a compilation unit node and that binding are correct
		assertTrue("Not a compilation unit", result.getNodeType() == ASTNode.COMPILATION_UNIT);
		CompilationUnit compilationUnit = (CompilationUnit) result;
		if (resolveBindings && compilationUnit.getProblems().length == 0) {
			compilationUnit.accept(new NullBindingVerifier());
		}
		return result;
	}

	public ASTNode runConversion(int astLevel, IClassFile classFile, int position, boolean resolveBindings) {

		// Create parser
		ASTParser parser = ASTParser.newParser(astLevel);
		parser.setSource(classFile);
		parser.setFocalPosition(position);
		parser.setResolveBindings(resolveBindings);

		// Parse compilation unit
		ASTNode result = parser.createAST(null);
		
		// Verify we get a compilation unit node and that binding are correct
		assertTrue("Not a compilation unit", result.getNodeType() == ASTNode.COMPILATION_UNIT);
		CompilationUnit compilationUnit = (CompilationUnit) result;
		if (resolveBindings && compilationUnit.getProblems().length == 0) {
			compilationUnit.accept(new NullBindingVerifier());
		}
		return result;
	}
	
	public ASTNode runConversion(int astLevel, char[] source, String unitName, IJavaProject project) {
		ASTParser parser = ASTParser.newParser(astLevel);
		parser.setSource(source);
		parser.setUnitName(unitName);
		parser.setProject(project);
		return parser.createAST(null);
	}

	public ASTNode runConversion(int astLevel, char[] source, String unitName, IJavaProject project, Map options) {
		ASTParser parser = ASTParser.newParser(astLevel);
		parser.setSource(source);
		parser.setUnitName(unitName);
		parser.setProject(project);
		parser.setCompilerOptions(options);
		return parser.createAST(null);
	}
	
	public ASTNode runConversion(char[] source, String unitName, IJavaProject project, Map options) {
		return runConversion(AST_INTERNAL_JLS2, source, unitName, project, options);
	}	

	protected ASTNode getASTNodeToCompare(org.eclipse.jdt.core.dom.CompilationUnit unit) {
		ExpressionStatement statement = (ExpressionStatement) getASTNode(unit, 0, 0, 0);
		return (ASTNode) ((MethodInvocation) statement.getExpression()).arguments().get(0);
	}

	protected ASTNode getASTNode(org.eclipse.jdt.core.dom.CompilationUnit unit, int typeIndex, int bodyIndex, int statementIndex) {
		BodyDeclaration bodyDeclaration = (BodyDeclaration) getASTNode(unit, typeIndex, bodyIndex);
		if (bodyDeclaration instanceof MethodDeclaration) {
			MethodDeclaration methodDeclaration = (MethodDeclaration) bodyDeclaration;
			Block block = methodDeclaration.getBody();
			return (ASTNode) block.statements().get(statementIndex);
		} else if (bodyDeclaration instanceof TypeDeclaration) {
			TypeDeclaration typeDeclaration = (TypeDeclaration) bodyDeclaration;
			return (ASTNode) typeDeclaration.bodyDeclarations().get(statementIndex);
		} else if (bodyDeclaration instanceof Initializer) {
			Initializer initializer = (Initializer) bodyDeclaration;
			Block block = initializer.getBody();
			return (ASTNode) block.statements().get(statementIndex);
		}
		return null;
	}

	protected ASTNode getASTNode(org.eclipse.jdt.core.dom.CompilationUnit unit, int typeIndex, int bodyIndex) {
		return (ASTNode) ((AbstractTypeDeclaration)unit.types().get(typeIndex)).bodyDeclarations().get(bodyIndex);
	}

	protected ASTNode getASTNode(org.eclipse.jdt.core.dom.CompilationUnit unit, int typeIndex) {
		return (ASTNode) unit.types().get(typeIndex);
	}
		
	protected void checkSourceRange(ASTNode node, String expectedContents, String source) {
		assertNotNull("The node is null", node); //$NON-NLS-1$
		assertTrue("The node(" + node.getClass() + ").getLength() == 0", node.getLength() != 0); //$NON-NLS-1$ //$NON-NLS-2$
		assertTrue("The node.getStartPosition() == -1", node.getStartPosition() != -1); //$NON-NLS-1$
		int length = node.getLength();
		int start = node.getStartPosition();
		String actualContentsString = source.substring(start, start + length);
		assertSourceEquals("Unexpected source", Util.convertToIndependantLineDelimiter(expectedContents), Util.convertToIndependantLineDelimiter(actualContentsString));
	}

	protected void checkSourceRange(ASTNode node, String expectedContents, char[] source) {
		assertNotNull("The node is null", node); //$NON-NLS-1$
		assertTrue("The node(" + node.getClass() + ").getLength() == 0", node.getLength() != 0); //$NON-NLS-1$ //$NON-NLS-2$
		assertTrue("The node.getStartPosition() == -1", node.getStartPosition() != -1); //$NON-NLS-1$
		int length = node.getLength();
		int start = node.getStartPosition();
		char[] actualContents = new char[length];
		System.arraycopy(source, start, actualContents, 0, length);
		String actualContentsString = new String(actualContents);
		assertSourceEquals("Unexpected source", Util.convertToIndependantLineDelimiter(expectedContents), Util.convertToIndependantLineDelimiter(actualContentsString));
	}
		
	protected boolean isMalformed(ASTNode node) {
		return (node.getFlags() & ASTNode.MALFORMED) != 0;
	}
	
	protected boolean isOriginal(ASTNode node) {
		return (node.getFlags() & ASTNode.ORIGINAL) != 0;
	}
	
	protected void assertProblemsSize(CompilationUnit compilationUnit, int expectedSize) {
		assertProblemsSize(compilationUnit, expectedSize, "");
	}
	protected void assertProblemsSize(CompilationUnit compilationUnit, int expectedSize, String expectedOutput) {
		final IProblem[] problems = compilationUnit.getProblems();
		final int length = problems.length;
		if (length != expectedSize) {
			checkProblemMessages(expectedOutput, problems, length);
			assertEquals("Wrong size", expectedSize, length);
		}
		checkProblemMessages(expectedOutput, problems, length);
	}

	private void checkProblemMessages(String expectedOutput, final IProblem[] problems, final int length) {
		if (length != 0) {
			if (expectedOutput != null) {
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < length; i++) {
					buffer.append(problems[i].getMessage());
					if (i < length - 1) {
						buffer.append('\n');
					}
				}
				String actualOutput = String.valueOf(buffer);
				expectedOutput = Util.convertToIndependantLineDelimiter(expectedOutput);
				actualOutput = Util.convertToIndependantLineDelimiter(actualOutput);
				if (!expectedOutput.equals(actualOutput)) {
					System.out.println(Util.displayString(actualOutput));
					assertEquals("different output", expectedOutput, actualOutput);
				}
			}
		}
	}
}
