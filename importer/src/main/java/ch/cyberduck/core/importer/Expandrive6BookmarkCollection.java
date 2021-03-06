package ch.cyberduck.core.importer;

    /*
     * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
     * https://cyberduck.io/
     *
     * This program is free software; you can redistribute it and/or modify
     * it under the terms of the GNU General Public License as published by
     * the Free Software Foundation, either version 3 of the License, or
     * (at your option) any later version.
     *
     * This program is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU General Public License for more details.
     */

import ch.cyberduck.core.Local;
import ch.cyberduck.core.LocalFactory;
import ch.cyberduck.core.preferences.PreferencesFactory;

public class Expandrive6BookmarkCollection extends ExpandriveBookmarkCollection {

    @Override
    public Local getFile() {
        return LocalFactory.get(PreferencesFactory.get().getProperty("bookmark.import.expandrive6.location"));
    }

    @Override
    public String getName() {
        return "ExpanDrive 6";
    }

    @Override
    public String getBundleIdentifier() {
        return "com.expandrive.ExpanDrive3";
    }

    public String getConfiguration() {
        return String.format("bookmark.import.%s%d", this.getBundleIdentifier(), 6);
    }
}
