package examples.MetadataOperations.AddMetadata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.groupdocs.cloud.metadata.api.MetadataApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.AddOptions;
import com.groupdocs.cloud.metadata.model.AddProperty;
import com.groupdocs.cloud.metadata.model.AddResult;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.MatchOptions;
import com.groupdocs.cloud.metadata.model.NameOptions;
import com.groupdocs.cloud.metadata.model.SearchCriteria;
import com.groupdocs.cloud.metadata.model.requests.AddRequest;

import examples.Common;

/**
 * This example demonstrates how to add metadata by match property name exact word (ignorecase).
 */
public class AddMetadataByPropertyNameMatchExactPhrase {

	public static void main(String[] args) {

		MetadataApi apiInstance = new MetadataApi(Common.GetConfiguration());

		try {
			AddOptions options = new AddOptions();
			ArrayList<AddProperty> properties = new ArrayList<AddProperty>();
			AddProperty property = new AddProperty();
			SearchCriteria searchCriteria = new SearchCriteria();
			NameOptions nameOptions = new NameOptions();
			nameOptions.setValue("Lastprinted");
			MatchOptions matchOptions = new MatchOptions();
			matchOptions.setExactPhrase(true);
			nameOptions.setMatchOptions(matchOptions);
			searchCriteria.setNameOptions(nameOptions);
			property.setSearchCriteria(searchCriteria);
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
			property.setValue(dateFormat.format(date));
			property.setType("datetime");
			properties.add(property);
			options.setProperties(properties);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.docx");
			options.setFileInfo(fileInfo);
			AddRequest request = new AddRequest(options);

			AddResult response = apiInstance.add(request);

			System.out.println("Count of changes: " + response.getAddedCount());
			System.out.println("Resultant file path: " + response.getPath());

		} catch (ApiException e) {
			System.err.println("Exception while calling MetadataApi:");
			e.printStackTrace();
		}
	}
}