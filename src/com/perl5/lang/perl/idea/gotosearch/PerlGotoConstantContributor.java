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

package com.perl5.lang.perl.idea.gotosearch;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.perl5.lang.perl.psi.PerlConstant;
import com.perl5.lang.perl.util.PerlSubUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hurricup on 12.08.2015.
 */
public class PerlGotoConstantContributor implements ChooseByNameContributor
{
	@NotNull
	@Override
	public String[] getNames(Project project, boolean includeNonProjectItems)
	{
		List<String> names = new ArrayList<String>();

		for (String name : PerlSubUtil.getDefinedConstantsNames(project))
			names.add(name);

		return names.toArray(new String[names.size()]);
	}

	@NotNull
	@Override
	public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems)
	{
		Collection<PerlConstant> result = PerlSubUtil.getConstantsDefinitions(project, name);
		return result.toArray(new NavigationItem[result.size()]);
	}
}