/*
 * Copyright 2019 New York University.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.urban.data.core.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A select clause is an ordered list of select terms. Each term has to have a
 * unique column name.
 * 
 * @author Heiko Mueller <heiko.mueller@nyu.edu>
 */
public class SelectClause {
   
    private final HashMap<String, Integer> _schema = new HashMap<>();
    private final List<JQuery> _columns = new ArrayList<>();
    
    public SelectClause add(String name, JQuery term) {
        
        if (_schema.containsKey(name)) {
            throw new IllegalArgumentException("Duplicate name:" + name);
        }
        
        _schema.put(name, _columns.size());
        _columns.add(term);
        
        return this;
    }
    
    public JQuery get(int index) {
        
        return _columns.get(index);
    }
    
    public HashMap<String, Integer> schema() {
        
        return _schema;
    }
    
    public int size() {
        
        return _columns.size();
    }
}
