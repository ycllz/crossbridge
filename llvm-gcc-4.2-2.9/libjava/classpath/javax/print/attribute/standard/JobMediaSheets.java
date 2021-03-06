/* JobMediaSheets.java -- 
   Copyright (C) 2003, 2005, 2006 Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */

package javax.print.attribute.standard;

import javax.print.attribute.IntegerSyntax;
import javax.print.attribute.PrintJobAttribute;
import javax.print.attribute.PrintRequestAttribute;

/**
 * The <code>JobMediaSheets</code> printing attribute specifies
 * the total number of media sheets needed by a job.
 * <p>
 * In contrary to the other job size attributes this attribute must include
 * the multiplication factor from the number of copies if a Copies attribute
 * was specified for the job.
 * </p>
 * <p>
 * This attribute belongs to a group of job size attributes which are 
 * describing the size of a job to be printed. The values supplied by
 * these attributes are intended to be used for routing and scheduling
 * of jobs on the print service. A client may specify these attributes.
 * If a clients supplies these attributes a print service may change
 * the values if its be able to compute a more accurate value at the
 * time of the job submission or also later.
 * </p>
 * <p>
 * <b>IPP Compatibility:</b> JobMediaSheets is an IPP 1.1 attribute.
 * </p>
 * @see javax.print.attribute.standard.JobKOctets
 * @see javax.print.attribute.standard.JobImpressions
 * 
 * @author Michael Koch
 */
public class JobMediaSheets extends IntegerSyntax
  implements PrintJobAttribute, PrintRequestAttribute
{
  private static final long serialVersionUID = 408871131531979741L;
  
  /**
   * Creates a <code>JobMediaSheets</code> object.
   *
   * @param value the number of media sheets for a print job
   *
   * @exception IllegalArgumentException if value &lt; 0
   */
  public JobMediaSheets(int value)
  {
    super(value);

    if (value < 0)
      throw new IllegalArgumentException("value may not be less than 0");
  }
  
  /**
   * Tests if the given object is equal to this object.
   *
   * @param obj the object to test
   *
   * @return <code>true</code> if both objects are equal, 
   * <code>false</code> otherwise.
   */
  public boolean equals(Object obj)
  {
    if(! (obj instanceof JobMediaSheets))
      return false;

    return super.equals(obj);
  }

  /**
   * Returns category of this class.
   *
   * @return The class <code>JobMediaSheets</code> itself.
   */
  public final Class getCategory()
  {
    return JobMediaSheets.class;
  }

  /**
   * Returns the name of this attribute.
   *
   * @return The name "job-media-sheets".
   */
  public final String getName()
  {
    return "job-media-sheets";
  }
}
