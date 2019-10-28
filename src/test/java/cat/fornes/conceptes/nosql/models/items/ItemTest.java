/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cat.fornes.conceptes.nosql.models.items;

import java.util.Arrays;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cat.fornes.conceptes.nosql.models.items.Item.ItemBuilder;

/**
 * Test of {@link Item} class.
 *
 * @author Octavi Fornés &lt;ofornes@albirar.cat&gt;
 * @since 1.0.0
 */
public class ItemTest
{
	private static final String [] TAGS = {"TAG1", "TAG2", "TAG3"};
	@Test
	public void testBuildersDefaults()
	{
		Item itm;
		
		itm = Item.builder()
				.name("test")
				.build();
		
		Assertions.assertEquals("test", itm.getName());
		Assertions.assertNotNull(itm.getNamedTags());
		Assertions.assertNotNull(itm.getTags());
	}
	@Test
	public void testSingulars()
	{
		Item itm;
		@SuppressWarnings( "rawtypes" )
		ItemBuilder itmBld;
		
		itmBld = Item.builder()
				;
		for(String t : TAGS)
		{
			itmBld.tag(t);
		}
		itm = itmBld.build();
		
		Assertions.assertNotNull(itm.getNamedTags());
		Assertions.assertNotNull(itm.getTags());
		
		Assertions.assertEquals(new TreeSet<>(Arrays.asList(TAGS)), itm.getTags());
	}
}
