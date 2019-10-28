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
package cat.fornes.conceptes.nosql.models.tags;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A named tag is a free content tag with a name that enable grouping by name.
 *
 * @author Octavi Fornés &lt;ofornes@albirar.cat&gt;
 * @since 1.0.0
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class NamedTag implements Serializable
{
	private static final long serialVersionUID = 5605093895748512162L;
	
	private String name;
	private String value;
}
