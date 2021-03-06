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

package com.perl5.lang.mason2.filetypes;

import com.intellij.lang.Language;
import com.perl5.lang.mason2.MasonIcons;
import com.perl5.lang.mason2.MasonLanguage;
import com.perl5.lang.perl.fileTypes.PerlFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by hurricup on 20.12.2015.
 */
public class MasonPurePerlComponentFileType extends PerlFileType
{
	public final static MasonPurePerlComponentFileType INSTANCE = new MasonPurePerlComponentFileType();

	public MasonPurePerlComponentFileType()
	{
		super(MasonLanguage.INSTANCE);
	}

	public MasonPurePerlComponentFileType(Language language)
	{
		super(language);
	}

	@NotNull
	@Override
	public String getName()
	{
		return "Mason2 pure Perl component";
	}

	@NotNull
	@Override
	public String getDescription()
	{
		return "Mason2 pure Perl component";
	}

	@NotNull
	@Override
	public String getDefaultExtension()
	{
		return "mp";
	}

	@Nullable
	@Override
	public Icon getIcon()
	{
		return MasonIcons.MASON_PURE_PERL_COMPONENT_ICON;
	}

	@Override
	public boolean checkStrictPragma()
	{
		return false;
	}

	@Override
	public boolean checkWarningsPragma()
	{
		return false;
	}
}
