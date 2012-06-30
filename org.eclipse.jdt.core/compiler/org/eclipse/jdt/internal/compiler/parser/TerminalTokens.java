/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * This is an implementation of an early-draft specification developed under the Java
 * Community Process (JCP) and is made available for testing and evaluation purposes
 * only. The code is not compatible with any specification of the JCP.
 *
 *
 * This is an implementation of an early-draft specification developed under the Java
 * Community Process (JCP) and is made available for testing and evaluation purposes
 * only. The code is not compatible with any specification of the JCP.
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.compiler.parser;

/**
 * IMPORTANT NOTE: These constants are dedicated to the internal Scanner implementation.
 * It is mirrored in org.eclipse.jdt.core.compiler public package where it is API.
 * The mirror implementation is using the backward compatible ITerminalSymbols constant
 * definitions (stable with 2.0), whereas the internal implementation uses TerminalTokens
 * which constant values reflect the latest parser generation state.
 */
/**
 * Maps each terminal symbol in the java-grammar into a unique integer.
 * This integer is used to represent the terminal when computing a parsing action.
 *
 * Disclaimer : These constant values are generated automatically using a Java
 * grammar, therefore their actual values are subject to change if new keywords
 * were added to the language (for instance, 'assert' is a keyword in 1.4).
 */
public interface TerminalTokens {

	// special tokens not part of grammar - not autogenerated
	int TokenNameNotAToken = 0,
		TokenNameWHITESPACE = 1000,
		TokenNameCOMMENT_LINE = 1001,
		TokenNameCOMMENT_BLOCK = 1002,
		TokenNameCOMMENT_JAVADOC = 1003;

	int TokenNameIdentifier = 19,
		TokenNameabstract = 46,
		TokenNameassert = 79,
		TokenNameboolean = 32,
		TokenNamebreak = 80,
		TokenNamebyte = 33,
		TokenNamecase = 107,
		TokenNamecatch = 105,
		TokenNamechar = 34,
		TokenNameclass = 77,
		TokenNamecontinue = 81,
		TokenNameconst = 113,
		TokenNamedefault = 90,
		TokenNamedo = 82,
		TokenNamedouble = 35,
		TokenNameelse = 109,
		TokenNameenum = 103,
		TokenNameextends = 104,
		TokenNamefalse = 57,
		TokenNamefinal = 47,
		TokenNamefinally = 108,
		TokenNamefloat = 36,
		TokenNamefor = 83,
		TokenNamegoto = 114,
		TokenNameif = 84,
		TokenNameimplements = 112,
		TokenNameimport = 106,
		TokenNameinstanceof = 17,
		TokenNameint = 37,
		TokenNameinterface = 89,
		TokenNamelong = 38,
		TokenNamenative = 48,
		TokenNamenew = 56,
		TokenNamenull = 58,
		TokenNamepackage = 91,
		TokenNameprivate = 49,
		TokenNameprotected = 50,
		TokenNamepublic = 51,
		TokenNamereturn = 85,
		TokenNameshort = 39,
		TokenNamestatic = 44,
		TokenNamestrictfp = 52,
		TokenNamesuper = 53,
		TokenNameswitch = 86,
		TokenNamesynchronized = 45,
		TokenNamethis = 43,
		TokenNamethrow = 87,
		TokenNamethrows = 111,
		TokenNametransient = 54,
		TokenNametrue = 59,
		TokenNametry = 88,
		TokenNamevoid = 40,
		TokenNamevolatile = 55,
		TokenNamewhile = 78,
		TokenNameIntegerLiteral = 60,
		TokenNameLongLiteral = 61,
		TokenNameFloatingPointLiteral = 62,
		TokenNameDoubleLiteral = 63,
		TokenNameCharacterLiteral = 64,
		TokenNameStringLiteral = 65,
		TokenNamePLUS_PLUS = 2,
		TokenNameMINUS_MINUS = 3,
		TokenNameEQUAL_EQUAL = 20,
		TokenNameLESS_EQUAL = 13,
		TokenNameGREATER_EQUAL = 14,
		TokenNameNOT_EQUAL = 21,
		TokenNameLEFT_SHIFT = 18,
		TokenNameRIGHT_SHIFT = 15,
		TokenNameUNSIGNED_RIGHT_SHIFT = 16,
		TokenNamePLUS_EQUAL = 92,
		TokenNameMINUS_EQUAL = 93,
		TokenNameMULTIPLY_EQUAL = 94,
		TokenNameDIVIDE_EQUAL = 95,
		TokenNameAND_EQUAL = 96,
		TokenNameOR_EQUAL = 97,
		TokenNameXOR_EQUAL = 98,
		TokenNameREMAINDER_EQUAL = 99,
		TokenNameLEFT_SHIFT_EQUAL = 100,
		TokenNameRIGHT_SHIFT_EQUAL = 101,
		TokenNameUNSIGNED_RIGHT_SHIFT_EQUAL = 102,
		TokenNameOR_OR = 31,
		TokenNameAND_AND = 30,
		TokenNamePLUS = 4,
		TokenNameMINUS = 5,
		TokenNameNOT = 69,
		TokenNameREMAINDER = 9,
		TokenNameXOR = 24,
		TokenNameAND = 22,
		TokenNameMULTIPLY = 8,
		TokenNameOR = 25,
		TokenNameTWIDDLE = 70,
		TokenNameDIVIDE = 10,
		TokenNameGREATER = 12,
		TokenNameLESS = 11,
		TokenNameLPAREN = 26,
		TokenNameRPAREN = 27,
		TokenNameLBRACE = 68,
		TokenNameRBRACE = 42,
		TokenNameLBRACKET = 6,
		TokenNameRBRACKET = 72,
		TokenNameSEMICOLON = 28,
		TokenNameQUESTION = 29,
		TokenNameCOLON = 71,
		TokenNameCOMMA = 41,
		TokenNameDOT = 1,
		TokenNameEQUAL = 74,
		TokenNameAT = 23,
		TokenNameELLIPSIS = 75,
		TokenNameARROW = 110,
		TokenNameCOLON_COLON = 7,
		TokenNameBeginLambda = 66,
		TokenNameBeginTypeArguments = 76,
		TokenNameElidedSemicolonAndRightBrace = 73,
		TokenNameEOF = 67,
		TokenNameERROR = 115;
}
