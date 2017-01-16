/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.owasp.passfault;

import org.junit.Test;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.impl.FinderByPropsBuilder;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class FinderByPropsBuilderTest {

  @Test
  public void byFile() throws Exception {
    System.out.println("current directory:" + new File(".").getCanonicalFile());
    File file = new File("src/test/resources/wordlists");
    assertTrue(file.exists());
    Collection<PatternFinder> finders = new FinderByPropsBuilder().
      isInMemory(false).
      setFileLoader(file).
      build();
    System.out.println("Finders found " + finders);
    assertTrue(finders.size() > 4);
  }

  @Test
  public void byResource() throws Exception {
    Collection<PatternFinder> finders = new FinderByPropsBuilder().
      loadDefaultWordLists().
      isInMemory(true).
      build();
    System.out.println("Finders found " + finders);
    assertTrue(finders.size() > 4);
  }
}
