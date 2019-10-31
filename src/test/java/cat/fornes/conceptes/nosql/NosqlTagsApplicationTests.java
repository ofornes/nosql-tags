package cat.fornes.conceptes.nosql;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import cat.fornes.conceptes.nosql.models.items.Item;
import cat.fornes.conceptes.nosql.models.tags.NamedTag;
import cat.fornes.conceptes.nosql.repos.ItemRepository;

@SpringBootTest
class NosqlTagsApplicationTests extends ArrelNosqlTagsTestAbstracte {

	@Autowired
	ItemRepository itemRepo;
	
	@BeforeEach
	void prepararDades()
	{
		for(Item it : ITEMS)
		{
			itemRepo.save(it);
		}
	}
	
	@Test
	void testColeccio()
	{
		List<Item> items;
		
		items = itemRepo.findAll();
		Assertions.assertEquals(ITEMS.length, items.size());
	}

	@Test
	void testCercarPerTag()
	{
		List<Item> items;
		SortedSet<Item> patro;
		Item itemPatro;
		
		patro = colleccioPerTag(TAG_CARN);
		Assertions.assertFalse(patro.isEmpty());
		
		items = itemRepo.findByTagsContaining(TAG_CARN, Sort.by("name").ascending());
		
		Assertions.assertEquals(patro.size(), items.size());
		for(Item it : items)
		{
			Assertions.assertTrue(patro.contains(it));
			itemPatro = patro.tailSet(it).first();
			patro.remove(itemPatro);
			Assertions.assertEquals(itemPatro, it);
		}
	}
	@Test
	void testCercarPerNamedTag()
	{
		List<Item> items;
		SortedSet<Item> patro;
		Item itemPatro;
		
		patro = colleccioPerNamedTagValue(NOM_TAG_BOTIGA, VALUE_BONAREA);
		Assertions.assertFalse(patro.isEmpty());
		
		items = itemRepo.findByNamedTags_NameEqualsAndNamedTags_ValuesContaining(NOM_TAG_BOTIGA, VALUE_BONAREA, Sort.by("name").ascending());
		
		Assertions.assertEquals(patro.size(), items.size());
		for(Item it : items)
		{
			Assertions.assertTrue(patro.contains(it));
			itemPatro = patro.tailSet(it).first();
			patro.remove(itemPatro);
			Assertions.assertEquals(itemPatro, it);
		}
	}

	private SortedSet<Item> colleccioPerTag(String tag)
	{
		SortedSet<Item> r;
		
		r = new TreeSet<>(Item.getComparator());
		
		for(Item item : ITEMS)
		{
			for(String itag : item.getTags())
			{
				if(itag.equals(tag))
				{
					r.add(item);
					break;
				}
			}
		}
		return r;
	}
	private SortedSet<Item> colleccioPerNamedTagValue(String name, String value)
	{
		SortedSet<Item> r;
		
		r = new TreeSet<>(Item.getComparator());
		
		for(Item item : ITEMS)
		{
			for(NamedTag itag : item.getNamedTags())
			{
				if(itag.getName().equals(name)
					&& itag.getValues().contains(value))
				{
					r.add(item);
					break;
				}
			}
		}
		return r;
	}
}
