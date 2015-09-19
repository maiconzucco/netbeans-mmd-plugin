/*
 * Copyright 2015 Igor Maznitsa.
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
package com.igormaznitsa.nbmindmap.nb.refactoring;

import java.io.File;
import javax.swing.undo.CannotUndoException;

public class CannotUndoMindMapException extends CannotUndoException {
  public static final long serialVersionUID = 12312439213L;
  
  private final String filePath;
  
  public CannotUndoMindMapException(final File file){
    this.filePath = file == null ? "<NULL>" : file.getAbsolutePath();
  }
  
  @Override
  public String getMessage(){
    return "Can't undo changes in file "+this.filePath;
  }
}
