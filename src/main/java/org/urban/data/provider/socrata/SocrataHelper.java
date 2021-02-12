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
package org.urban.data.provider.socrata;

import java.io.File;
import java.io.InputStreamReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.urban.data.core.util.FileSystem;

/**
 * Collection of helper methods for Socrata dataset files.
 * 
 * 
 * @author Heiko Mueller <heiko.mueller@nyu.edu>
 */
public final class SocrataHelper {
    
    public static CSVParser tsvParser(File file) throws java.io.IOException {
        
        return new CSVParser(
                new InputStreamReader(FileSystem.openFile(file)),
                CSVFormat.TDF
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withIgnoreSurroundingSpaces(false)
        );
    }
}
