/*
 * Copyright (C) 2010-2011 Geometer Plus <contact@geometerplus.com>
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
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader.network;

import android.app.Activity;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.MenuItem;

import org.geometerplus.fbreader.network.NetworkLibrary;
import org.geometerplus.fbreader.network.NetworkTree;

import org.geometerplus.android.fbreader.network.action.ActionCode;

abstract class NetworkTreeActions {
	// special values to return from getDefaultActionCode(NetworkTree)
	protected final String getTitleValue(String key) {
		return NetworkLibrary.resource().getResource(key).getValue();
	}

	protected final String getTitleValue(String key, String arg) {
		return NetworkLibrary.resource().getResource(key).getValue().replace("%s", arg);
	}

	/*
	protected final String getOptionsValue(String key) {
		return NetworkLibrary.resource().getResource("menu").getResource(key).getValue();
	}

	protected final String getOptionsValue(String key, String arg) {
		return NetworkLibrary.resource().getResource("menu").getResource(key).getValue().replace("%s", arg);
	}
	*/

	protected final MenuItem addMenuItemWithText(ContextMenu menu, int id, String text) {
		return menu.add(0, id, 0, text).setEnabled(id != ActionCode.TREE_NO_ACTION);
	}

	protected final MenuItem addMenuItem(ContextMenu menu, int id, String key) {
		return addMenuItemWithText(menu, id, getTitleValue(key));
	}

	protected final MenuItem addMenuItem(ContextMenu menu, int id, String key, String arg) {
		return addMenuItemWithText(menu, id, getTitleValue(key, arg));
	}

	public abstract int getDefaultActionCode(NetworkLibraryActivity activity, NetworkTree tree);

	public abstract boolean runAction(NetworkLibraryActivity activity, NetworkTree tree, int actionCode);

	public void buildContextMenu(NetworkLibraryActivity activity, ContextMenu menu, NetworkTree tree) {
	}
}
