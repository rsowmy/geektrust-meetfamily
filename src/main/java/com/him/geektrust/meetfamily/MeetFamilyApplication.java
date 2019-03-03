package com.him.geektrust.meetfamily;

import java.util.List;

import com.him.geektrust.meetfamily.model.FamilyTree;
import com.him.geektrust.meetfamily.model.InputFileData;

/**
 * The task of this class is to just start and run the application. Its just
 * playing the role of orchestrator.
 * 
 * @author himanshu
 *
 */
public class MeetFamilyApplication {

	public static void main(String[] args) {
		String pathOfInputFile = args[0];

		FamilyTree familyTree = FamilyTreeInitializer.initializeFamilyTree();

		List<InputFileData> inputFileContent = FileProcessor.processFile(pathOfInputFile);

		inputFileContent.stream().forEach(inputLineData -> inputLineData.getOperation().getProcessor()
				.processOperation(inputLineData.getArguments(), familyTree));
	}

}
