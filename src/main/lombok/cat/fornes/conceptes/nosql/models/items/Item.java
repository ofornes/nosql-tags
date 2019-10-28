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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cat.fornes.conceptes.nosql.models.tags.NamedTag;
import lombok.Builder.ObtainVia;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

/**
 * A taggeable item.
 *
 * @author Octavi Fornés &lt;ofornes@albirar.cat&gt;
 * @since 1.0.0
 */
@Data
@SuperBuilder
@NoArgsConstructor
@Document(collection = "items")
public class Item implements Serializable
{
	private static final long serialVersionUID = 3496586130637161852L;

	@Id
	private String id;
	
	private String name;
	
	/**
	 * A sorted set of tags (texts).
	 * @param tags The sorted set of tags
	 * @return a sorted set of tags, can be empty
	 */
	private @Singular @ObtainVia(method = "initTags") SortedSet<String> tags;
	/**
	 * Named tags are a list of free value tags associated with a name each.
	 * @param namedTags A map of named tags, with name as key and {@link NamedTag} as value
	 * @return A map of named tags, can be empty.
	 */
	private @Singular @ObtainVia(method = "initNamedTags") Map<String, NamedTag> namedTags;
	
	@SuppressWarnings( "unused" )
	private Map<String, NamedTag> initNamedTags()
	{
		return new HashMap<>();
	}
	@SuppressWarnings( "unused" )
	private SortedSet<String> initTags()
	{
		return new TreeSet<>();
	}
}
