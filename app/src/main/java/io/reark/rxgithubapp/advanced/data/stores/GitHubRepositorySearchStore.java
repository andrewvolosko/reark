/*
 * The MIT License
 *
 * Copyright (c) 2013-2016 reark project contributors
 *
 * https://github.com/reark/reark/graphs/contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.reark.rxgithubapp.advanced.data.stores;

import com.google.gson.Gson;

import android.content.ContentResolver;
import android.support.annotation.NonNull;

import io.reark.reark.data.stores.DefaultStore;
import io.reark.rxgithubapp.advanced.data.stores.cores.GitHubRepositorySearchStoreCore;
import io.reark.rxgithubapp.shared.pojo.GitHubRepositorySearch;

import static io.reark.reark.utils.Preconditions.get;

public class GitHubRepositorySearchStore
        extends DefaultStore<String, GitHubRepositorySearch, GitHubRepositorySearch> {

    @NonNull
    private static final GetIdForItem<String, GitHubRepositorySearch> getIdForItem =
            search -> get(search).getSearch();

    @NonNull
    private static final GetNullSafe<GitHubRepositorySearch, GitHubRepositorySearch> getNullSafe =
            search -> search != null ? search : GitHubRepositorySearch.none();

    @NonNull
    private static final GetEmptyValue<GitHubRepositorySearch> getEmptyValue =
            GitHubRepositorySearch::none;

    public GitHubRepositorySearchStore(@NonNull final ContentResolver contentResolver, @NonNull final Gson gson) {
        super(new GitHubRepositorySearchStoreCore(contentResolver, gson),
                getIdForItem,
                getNullSafe,
                getEmptyValue);
    }

}
