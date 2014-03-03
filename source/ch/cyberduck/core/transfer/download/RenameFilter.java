package ch.cyberduck.core.transfer.download;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.Local;
import ch.cyberduck.core.LocalFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.core.transfer.symlink.SymlinkResolver;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public class RenameFilter extends AbstractDownloadFilter {
    private static final Logger log = Logger.getLogger(RenameFilter.class);

    public RenameFilter(final SymlinkResolver symlinkResolver, final Session<?> session) {
        super(symlinkResolver, session, new DownloadFilterOptions());
    }

    public RenameFilter(final SymlinkResolver symlinkResolver, final Session<?> session,
                        final DownloadFilterOptions options) {
        super(symlinkResolver, session, options);
    }

    @Override
    public TransferStatus prepare(final Path file, final Local local, final TransferStatus parent) throws BackgroundException {
        final TransferStatus status = super.prepare(file, local, parent);
        if(local.exists()) {
            final String parentPath = local.getParent().getAbsolute();
            final String filename = file.getName();
            int no = 0;
            do {
                no++;
                String proposal = String.format("%s-%d", FilenameUtils.getBaseName(filename), no);
                if(StringUtils.isNotBlank(FilenameUtils.getExtension(filename))) {
                    proposal += "." + FilenameUtils.getExtension(filename);
                }
                status.rename(LocalFactory.createLocal(parentPath, proposal));
            }
            while(status.getRename().local.exists());
            if(log.isInfoEnabled()) {
                log.info(String.format("Changed local name from %s to %s", filename, status.getRename().local.getName()));
            }
        }
        return status;
    }

    @Override
    public void apply(final Path file, final Local local, final TransferStatus status) throws BackgroundException {
        if(local.exists()) {
            // Set renamed target
            status.rename(status.getRename().local);
        }
    }
}