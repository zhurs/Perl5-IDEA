/*
 * Copyright 2015 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.mason;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.perl5.lang.mason.elementType.MasonElementTypes;
import com.perl5.lang.mason.elementType.MasonFileElementType;
import com.perl5.lang.mason.lexer.MasonLexerAdapter;
import com.perl5.lang.mason.psi.impl.*;
import com.perl5.lang.perl.PerlParserDefinition;
import com.perl5.lang.perl.parser.MasonParserImpl;
import org.jetbrains.annotations.NotNull;

/**
 * Created by hurricup on 20.12.2015.
 */
public class MasonParserDefinition extends PerlParserDefinition implements MasonElementTypes
{
	public static final IFileElementType FILE = new MasonFileElementType("Mason component", MasonLanguage.INSTANCE);

	public static final TokenSet COMMENTS = TokenSet.orSet(PerlParserDefinition.COMMENTS,
			TokenSet.create(
					MASON_LINE_OPENER,
					MASON_TEMPLATE_BLOCK_HTML
			));
	@NotNull
	@Override
	public Lexer createLexer(Project project)
	{
		return new MasonLexerAdapter(project);
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return FILE;
	}

	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new MasonFileImpl(viewProvider);
	}

	@NotNull
	public TokenSet getCommentTokens()
	{
		return COMMENTS;
	}

	@NotNull
	@Override
	public PsiParser createParser(Project project)
	{
		return new MasonParserImpl();
	}

	@NotNull
	@Override
	public PsiElement createElement(ASTNode node)
	{
		IElementType elementType = node.getElementType();
		if (elementType == MASON_OVERRIDE_DEFINITION)
		{
			return new MasonOverrideDefinitionImpl(node);
		}
		else if (elementType == MASON_NAMESPACE_DEFINITION)
		{
			return new MasonNamespaceDefinitionImpl(node);
		}
		else if (elementType == MASON_FLAGS_STATEMENT)
		{
			return new MasonFlagsStatementImpl(node);
		}
		else if (elementType == MASON_ABSTRACT_BLOCK)
		{
			return new MasonAbstractBlockImpl(node);
		}
		else if (elementType == MASON_FILTERED_BLOCK)
		{
			return new MasonFilteredBlockImpl(node);
		}
		else if (elementType == MASON_SIMPLE_DEREF_EXPR)
		{
			return new MasonSimpleDerefExpressionImpl(node);
		}
		else if (elementType == MASON_METHOD_DEFINITION)
		{
			return new MasonMethodDefinitionImpl(node);
		}
		else if (elementType == MASON_FILTER_DEFINITION)
		{
			return new MasonFilterDefinitionImpl(node);
		}
		else if (elementType == MASON_AROUND_MODIFIER)
		{
			return new MasonAroundMethodModifierImpl(node);
		}
		else if (elementType == MASON_AFTER_MODIFIER || elementType == MASON_BEFORE_MODIFIER || elementType == MASON_AUGMENT_MODIFIER)
		{
			return new MasonMethodModifierImpl(node);
		}

		return super.createElement(node);
	}
}