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

package com.perl5.lang.perl.psi.stubs.namespace.definitions;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.perl5.lang.perl.psi.PerlNamespaceDefinition;
import com.perl5.lang.perl.psi.stubs.PerlStubElementTypes;

/**
 * Created by hurricup on 28.05.2015.
 */
public class PerlNamespaceDefinitionStubImpl extends StubBase<PerlNamespaceDefinition> implements PerlNamespaceDefinitionStub
{
	private final String packageName;

	public PerlNamespaceDefinitionStubImpl(final StubElement parent, final String packageName)
	{
		super(parent, PerlStubElementTypes.PERL_NAMESPACE);
		this.packageName = packageName;
	}

	public String getPackageName()
	{
		return packageName;
	}
}